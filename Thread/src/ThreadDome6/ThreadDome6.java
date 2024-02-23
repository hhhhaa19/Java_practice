package ThreadDome6;

/**
 * Created with IntelliJ IDEA.
 * Description:有三个线程，分别只能打印A，B和C
 * 要求按顺序打印ABC，打印10次
 * 用数字来控制顺序
 * User: 王金涛
 * Date: 2024-02-21
 * Time: 21:46
 */
public class ThreadDome6 {
//    public static void main1(String[] args) {
//        Object locker = new Object();
//        Thread thread3 = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                synchronized (locker) {
//                    if (i % 3 == 0) {
//                        System.out.println("A");
//                        locker.notify();
//                    } else {
//                        try {
//                            locker.wait();
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                }
//            }
//        });
//
//        Thread thread2 = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                synchronized (locker) {
//                    if (i % 3 == 1) {
//                        System.out.println("B");
//                        locker.notify();
//                    } else {
//                        try {
//                            locker.wait();
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                }
//            }
//        });
//        Thread thread1 = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                synchronized (locker) {
//                    if (i % 3 == 2) {
//                        System.out.println("C");
//                        locker.notify();
//                    } else {
//                        try {
//                            locker.wait();
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                }
//            }
//        });
//        thread1.start();
//        thread2.start();
//        thread3.start();
//    }

    // 计数器
    public static int count = 0;

    //那我们如何来控制线程间的相对顺序：join，wait,给一个先后执行的“编码”
    public static void main(String[] args) {
        Object locker = new Object();
        Object locker2 = new Object();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (locker) {
                    while (count % 3 != 0) {
                        try {
                            locker.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("A");
                    count++;
                    locker.notifyAll();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (locker) {
                    synchronized (locker) {
                        while (count % 3 != 1) {
                            try {
                                locker.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print("B");
                        count++;
                        locker.notifyAll();
                    }
                }
            }
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (locker) {
                    synchronized (locker) {
                        while (count % 3 != 2) {
                            try {
                                locker.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("C");
                        count++;
                        locker.notifyAll();
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
