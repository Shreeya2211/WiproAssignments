package springex8;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect
{

    public void logBefore() 
    {
        System.out.println("[Before] Method execution started.");
    }

    public void logAfterReturning() 
    {
        System.out.println(" [AfterReturning] Method executed successfully.");
    }

    public void logAfterThrowing() 
    {
        System.out.println("[AfterThrowing] An exception occurred during method execution.");
    }

    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable
    {
        System.out.println("[Around] Execution started.");
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        System.out.println("[Around] Execution finished. Duration: " + (endTime - startTime) + " ms.");

        return result;
    }
}
