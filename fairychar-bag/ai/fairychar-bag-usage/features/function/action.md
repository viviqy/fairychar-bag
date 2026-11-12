# Action 通用函数式接口

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：可直接采用**。`Action` 是常用的无参数、无返回值函数式接口，用于把一段操作作为值保存、传参和调用。它是普通业务代码也可使用的基础类型，不属于并发工具，也不限于 SDK 回调。无需 Spring Bean、配置开关或外部服务。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## 接口与基本含义

位置: `com.fairychar.bag.function.Action`

```java
@FunctionalInterface
public interface Action {
    void doAction() throws RuntimeException;
}
```

唯一抽象方法是 `doAction()`，不是 `run()`、`call()` 或 `execute()`。可以把它理解为与 `Runnable` 形状相似、但 Java 类型不同的动作接口。

| 项目 | 确定语义 |
| --- | --- |
| 输入 | `doAction()` 不接收参数；需要业务数据时由 lambda 捕获变量，或使用对象方法引用 |
| 返回 | 返回 `void`，不提供结果值或成功标记；需要结果时使用 `Supplier<T>` 等符合被调用 API 签名的接口 |
| 执行时机 | 创建 lambda 或方法引用不会执行动作；调用 `doAction()` 时才执行 |
| 调用 | `action.doAction()` 是普通方法调用；接口不额外改变执行方式 |
| 重复调用 | 每次调用都会重新执行；是否幂等由动作内容决定 |
| 异常 | 运行时异常直接从直接调用处传播；接口不捕获、包装或吞掉异常；也不声明受检异常 |

## 最小完整示例：lambda、方法引用与执行

下面的类可以使用 SDK JAR 编译，不依赖业务对象。

```java
import com.fairychar.bag.function.Action;
import java.util.ArrayList;
import java.util.List;

public class ActionUsageExample {
    public static void main(String[] args) {
        List<String> messages = new ArrayList<>();
        Action append = () -> {
            messages.add("saved");
        };
        if (!messages.isEmpty()) {
            throw new IllegalStateException("Creation must not execute the action");
        }
        append.doAction();
        append.doAction();
        if (!messages.equals(List.of("saved", "saved"))) {
            throw new IllegalStateException("Each invocation must execute the action");
        }

        Action print = ActionUsageExample::printCompleted;
        print.doAction();
    }

    private static void printCompleted() {
        System.out.println("completed");
    }
}
```

业务方法需要参数时，可以写成 `Action save = () -> userService.save(query);`；其中 `userService`、`query` 是业务已有对象。lambda 捕获的局部变量必须是 final 或 effectively final；捕获对象仍是同一引用，不会自动复制对象、请求上下文或事务。

## 在普通业务方法中传递操作

可以在自己的业务方法中声明 `Action` 参数，由调用方提供要执行的操作。下面是业务辅助方法片段，不是 SDK 新增 API：

```java
public void executeOperation(Action operation) {
    operation.doAction();
}
```

在有该方法的业务类中，可以直接写 `executeOperation(() -> userService.save(query));`，或 `executeOperation(this::refreshSummary);`。其中 Service、请求对象和无参方法由业务定义。不必先创建实现类，也不必将动作注册为 Bean。

一个 lambda 中可以按顺序写多条语句；前一条抛异常时，后续语句不再执行。`return;` 只结束当前 lambda，不自动结束调用它的外层业务方法。

## 作为 SDK 回调传入

SDK 方法参数声明为 `Action` 时，同样直接传 lambda 或兼容的方法引用。具体何时调用、调用几次、是否捕获异常，以接收该回调的功能契约为准；这些不是函数接口自身定义的规则。

`Action` 与动作流 `ActionFlow` 是不同类型，不要因为名字相近就将它视为流程引擎或任务执行器。

## 与其他函数接口的选择和适配

| 需求 | 使用方式 |
| --- | --- |
| SDK 参数声明为 `Action` | 传 `() -> { ... }`、无参方法引用或已有 Action |
| 无参动作需要返回结果 | 根据 API 签名使用 `Supplier<T>` 等接口，不要臆造 Action 泛型/返回值 |
| 动作需要接收参数 | 使用符合 API 签名的 `Consumer<T>` 等接口，或通过闭包捕获明确的业务参数 |
| 把已有 Action 交给需要 Runnable 的 API | 显式适配为 `Runnable runnable = action::doAction;` |
| 把已有 Runnable 传给 Action 参数 | 显式适配为 `Action action = runnable::run;`；两个已有接口对象不能直接互相赋值 |

动作可能抛 `IOException` 等受检异常时，必须在 lambda 内处理，或根据业务异常约定转换为运行时异常；不能因签名写了 `throws RuntimeException` 就直接抛任意受检异常。

## 空值、副作用与验证

- `Action action = null` 不会自动变成空动作，直接调用会抛 `NullPointerException`。需要空动作时显式使用 `() -> {}`，是否允许空回调仍看接收 API 的契约。
- 修改对象、数据库、文件等副作用来自动作内容；接口本身不提供事务、回滚或其他额外控制。
- 业务测试应确认：创建时不执行、调用次数与动作次数一致、执行顺序正确、运行时异常可被观测。

## 类型与完整签名

- [`com.fairychar.bag.function.Action`](../../api/function.md)
