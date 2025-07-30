package myjavademos;

/*
 * | Term                 | Meaning                                                                   |
| -------------------- | ------------------------------------------------------------------------- |
| `Garbage Collection` | Process of automatically freeing memory by destroying unreachable objects |
| `System.gc()`        | Requests JVM to perform GC (not guaranteed)                               |
| `finalize()`         | Called before object is garbage collected (used for cleanup, deprecated)  |
| Reference is `null`  | Object becomes **eligible** for GC                                        |

Garbage collection is not guaranteed immediately. System.gc() only requests GC — the JVM may or may not run it right away.

finalize() is deprecated in newer Java versions, but still useful for educational purposes
 */

//In modern Java (9+), prefer try-with-resources or AutoCloseable for cleanup instead of finalize().

/*
 * finalize method::
 * --java.lang.Object class
 * --This method is just called before the object is going to get GC process!
 * --this method cannot be invoked more than once by a JVM for any given object!
 * --override this method to receive the NOTIFICATION from the JVM(GC)
 * --dispose or cleanup the program resources!!
		 //Neither finalization nor garbage collection is guaranteed.

 */

public class GarbageCollectionDemo {
	//JVM CALLS THIS FINALIZE METHOD BEFORE GC HAPPENS!
	//Rightclick->Source->Override/Implement methods->select finalize()
	
	@Override
	protected void finalize() throws Throwable //valid
	//public void finalize() throws Throwable//valid
	//void finalize() throws Throwable //invalid=>Cannot decrease the visibility of the method
		{
		System.out.println("GC Tool invoke in some few mins!!");
		System.out.println("GC Tool calls object :::" +this.getClass());
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		GarbageCollectionDemo obj=new GarbageCollectionDemo();
		@SuppressWarnings("unused")
		GarbageCollectionDemo obj1=new GarbageCollectionDemo();

		obj=null;//unused or unreferenced obj, eligible for GC process
		System.gc();//Runs the garbage collector.

		obj1=null;//unused or unreferenced obj, eligible for GC process
		Runtime r1=Runtime.getRuntime();//An application cannot create its own instance of this class.
		r1.gc();//Runs the garbage collector.

		System.out.println("HELLO MAIN METHOD!");

	}

}
/*
GC Tool invoke in some few mins!!
GC Tool calls object :::class myjavademos.GarbageCollectionDemo
HELLO MAIN METHOD!
GC Tool invoke in some few mins!!
GC Tool calls object :::class myjavademos.GarbageCollectionDemo
*/