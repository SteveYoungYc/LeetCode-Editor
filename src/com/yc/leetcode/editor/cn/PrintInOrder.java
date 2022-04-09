package com.yc.leetcode.editor.cn;

import java.util.concurrent.Semaphore;

class PrintInOrder {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Foo {
        private final Semaphore two = new Semaphore(0);
        private final Semaphore three = new Semaphore(0);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            two.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            two.acquire();
            printSecond.run();
            three.release();
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            three.acquire();
            printThird.run();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}