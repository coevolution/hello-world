package cn.john.lu.micrometer.counter;

import io.micrometer.core.instrument.FunctionCounter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.ToDoubleFunction;

public class FunctionCounterMain {

    public static void main(String[] args) throws Exception {
        MeterRegistry registry = new SimpleMeterRegistry();
        AtomicInteger n = new AtomicInteger(0);
        //这里ToDoubleFunction匿名实现其实可以使用Lambda表达式简化为AtomicInteger::get
        FunctionCounter.builder("functionCounter", n, new ToDoubleFunction<AtomicInteger>() {
            @Override public double applyAsDouble(AtomicInteger value) {
                return value.get();
            }
        }).baseUnit("function").description("functionCounter").tag("createOrder", "CHANNEL-A")
            .register(registry);
        //下面模拟三次计数
        n.incrementAndGet();
        n.incrementAndGet();
        n.incrementAndGet();
        registry.forEachMeter(each -> {
            StringBuilder builder = new StringBuilder();
            builder.append("name:").append(each.getId().getName()).append(",tags:")
                .append(each.getId().getTags()).append(",type:").append(each.getId().getType())
                .append(",value:").append(each.measure());
            System.out.println(builder.toString());
        });
    }
}
