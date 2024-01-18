package flow;

import com.fairychar.bag.extension.action.condition.bool.AbstractActionFlow;
import com.fairychar.bag.extension.action.condition.bool.FlowBuilder;
import org.junit.Test;

import java.util.HashSet;

/**
 * @author chiyo
 * @since 1.0.2
 */
public class ActionFlowTest {

    @Test
    public void testBuild() {
        HashSet<Class<AbstractActionFlow>> classes = new HashSet<>();
        FlowBuilder builder = FlowBuilder.fromClasses(classes);
        AbstractActionFlow root = builder.buildFlow();
        root.callNext(null);
    }
}
