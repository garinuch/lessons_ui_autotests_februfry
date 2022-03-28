package ru.gb.lessons.Lesson4;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimerTestExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
    private static Logger logger = LoggerFactory.getLogger(TimerTestExtension.class);

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        long endTime = System.currentTimeMillis();
        long startTime = (long) extensionContext.getStore(ExtensionContext.Namespace.GLOBAL).get("startTime");
        logger.info("End test: " + extensionContext.getDisplayName() + " with duration: " + (endTime - startTime) + "ms");
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        long startTime = System.currentTimeMillis();
        extensionContext.getStore(ExtensionContext.Namespace.GLOBAL).put("startTime", startTime);
        logger.info("Start test: " + extensionContext.getDisplayName());
    }
}
