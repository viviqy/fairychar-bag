package com.fairychar.bag.beans.swagger;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import springfox.documentation.service.ListVendorExtension;
import springfox.documentation.service.ResolvedMethodParameter;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.OperationBuilderPlugin;
import springfox.documentation.spi.service.contexts.OperationContext;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/***
 * 忽略接口某个参数,避免编写过多的实体类,该插件通过给Open API v2.0 的Path节点添加扩展属性x-ignoreParameters扩展属性,结合前端ui自定义实现过滤规则.
 * 2.0.3版本添加includeParameters属性的支持
 * @since:swagger-bootstrap-ui 1.9.5
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/07/30 15:32
 */
@Order(Ordered.HIGHEST_PRECEDENCE + 103)
public class RequestIgnoreParameterPlugin implements OperationBuilderPlugin {

    public static final String IGNORE_PARAMETER_EXTENSION_NAME = "x-ignoreParameters";

    public static final String INCLUDE_PARAMETER_EXTENSION_NAME = "x-includeParameters";

    @Override
    public void apply(OperationContext context) {
        handleRequest(context);
    }

    private void handleRequest(OperationContext context) {
        for (ResolvedMethodParameter methodParameter : context.getParameters()) {
            if (methodParameter.hasParameterAnnotation(ShowParam.class)) {
                ShowParam showParam = methodParameter.getAnnotations().stream().filter(a -> a instanceof ShowParam).map(a -> ((ShowParam) a)).findFirst().get();
                Class<?> objectClass = methodParameter.getParameterType().getErasedType();
                List<String> hiddenFields = handleParamShow(showParam, objectClass, context);
                addExtensionParameters(hiddenFields.toArray(new String[]{}), IGNORE_PARAMETER_EXTENSION_NAME, context);
            }
        }
//        addExtensionParameters(new String[]{},IGNORE_PARAMETER_EXTENSION_NAME,context);
    }

    private List<String> handleParamShow(ShowParam showParam, Class objectClass, OperationContext context) {
        Set<Class> paramGroups = Arrays.stream(showParam.value()).collect(Collectors.toSet());
        List<String> hiddenFields = new ArrayList<>();
        List<String> showFields = new ArrayList<>();
        for (Field declaredField : objectClass.getDeclaredFields()) {
            ShowParam fieldAnnotation = declaredField.getAnnotation(ShowParam.class);
            if (fieldAnnotation != null) {
                int fieldAnnotationLength = fieldAnnotation.value().length;
                Set<Class> mixGroups = Arrays.asList(fieldAnnotation.value()).stream().collect(Collectors.toSet());
                mixGroups.addAll(paramGroups);
                if (mixGroups.size() == (paramGroups.size() + fieldAnnotationLength)) {
                    hiddenFields.add(declaredField.getName());
                } else if (mixGroups.size() < (paramGroups.size() + fieldAnnotationLength)) {
                    showFields.add(declaredField.getName());
                }
            } else {
                hiddenFields.add(declaredField.getName());
            }
        }
//        addExtensionParameters(hiddenFields.toArray(new String[]{}), IGNORE_PARAMETER_EXTENSION_NAME, context);
//        addExtensionParameters(showFields.toArray(new String[]{}), INCLUDE_PARAMETER_EXTENSION_NAME, context);
        return hiddenFields;
    }


    @Override
    public boolean supports(DocumentationType delimiter) {
        return true;
    }

    /**
     * 添加扩展属性参数
     *
     * @param params        参数
     * @param extensionName 扩展名称
     * @param context       上下文
     */
    private void addExtensionParameters(String[] params, String extensionName, OperationContext context) {
        if (params != null && params.length > 0) {
            Map<String, Boolean> map = new HashMap<>();
            for (String ignore : params) {
                if (ignore != null && !"".equals(ignore) && !"null".equals(ignore)) {
                    map.put(ignore, true);
                }
            }
            if (map.size() > 0) {
                List<Map<String, Boolean>> maps = new ArrayList<>();
                maps.add(map);
                ListVendorExtension<Map<String, Boolean>> listVendorExtension = new ListVendorExtension<>(extensionName, maps);
                List<VendorExtension> vendorExtensions = new ArrayList<>();
                vendorExtensions.add(listVendorExtension);
                //context.operationBuilder().extensions(Lists.newArrayList(listVendorExtension));
                context.operationBuilder().extensions(vendorExtensions);
            }
        }
    }
}
