/**
 * 单例模式保证一个类只有一个实例
 */
//饿汉模式
class singleton {
    public static singleton instance = new singleton();

    private singleton() {
    }

    public static singleton getInstance() {
        return instance;
    }
}

//饱汉模式
//线程不安全（同时创建两个对象）->synchronized
//提高效率，不希望每次都加锁（线程安全主要针对写操作，读操作无所谓）
class singleton1 {
    private static volatile singleton1 instance = null;

    private singleton1() {
    }

    public static singleton1 getInstance() {
        if (instance == null) {
            //为空，要进行写操作，要加锁
            synchronized (singleton1.class) {
                //这个if也是必要的，加了锁以后，两个判断条件间隔的时间可能沧海桑田，之前可能已经有线程创建了对象
                //然后对于出现在多线程中的用于沟通多个线程的变量，要加volatile来保证内存可见性
                if (instance == null) {
                    instance = new singleton1();
                }
                return instance;
            }
        } else {
            return instance;
        }
    }
}

