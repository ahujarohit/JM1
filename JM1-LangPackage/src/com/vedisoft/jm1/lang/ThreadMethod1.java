package com.vedisoft.jm1.lang;

class ThreadMethod1 {

    public static void main(String args[]) {
        Thread t = Thread.currentThread();
        System.out.println("Current Thread : " + t);
        System.out.println("Name Of The Current Thread : " + t.getName());
        System.out.println("Priority : " + t.getPriority());
        t.setName("MyThread");
        System.out.println("After Name Changed" + t.getName());
        t.setPriority(2);
        System.out.println("Afetr Priority Changed : " + t);
    }
}

/**
* Vedisoft : Java - Module 1 "Desktop Technologies"
*
*
*   Vedisoft Software & Education Services Pvt. Ltd.
*   Plot No. 275, Zone II, M.P. Nagar,
*   Bhopal.
*   Phone : 0755 - 4076207, 4076208
*   Email : contact@vedisoft.com
*   Web : www.vedisoft.com
*/