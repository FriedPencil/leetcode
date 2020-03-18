/*
�����ṩ��һ���ࣺ

public class Foo {
  public void one() { print("one"); }
  public void two() { print("two"); }
  public void three() { print("three"); }
}
������ͬ���߳̽��Ṳ��һ�� Foo ʵ����

�߳� A ������� one() ����
�߳� B ������� two() ����
�߳� C ������� three() ����
������޸ĳ�����ȷ�� two() ������ one() ����֮��ִ�У�three() ������ two() ����֮��ִ�С�

 

ʾ�� 1:

����: [1,2,3]
���: "onetwothree"
����: 
�������̻߳ᱻ�첽������
���� [1,2,3] ��ʾ�߳� A ������� one() �������߳� B ������� two() �������߳� C ������� three() ������
��ȷ������� "onetwothree"��
ʾ�� 2:

����: [1,3,2]
���: "onetwothree"
����: 
���� [1,3,2] ��ʾ�߳� A ������� one() �������߳� B ������� three() �������߳� C ������� two() ������
��ȷ������� "onetwothree"��
*/
class Foo {
    int flag;
    public Foo() {
        flag = 1;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized(this){
        if(flag == 1){
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        flag = 2;
        notifyAll();
        }
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized(this){
        while(flag != 2){
            wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        flag = 3;
        notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized(this){
        while(flag != 3){
            wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        }
    }
}