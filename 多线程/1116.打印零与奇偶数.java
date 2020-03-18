/*
��������ôһ���ࣺ

class ZeroEvenOdd {
  public ZeroEvenOdd(int n) { ... }      // ���캯��
  public void zero(printNumber) { ... }  // ����ӡ�� 0
  public void even(printNumber) { ... }  // ����ӡ�� ż��
  public void odd(printNumber) { ... }   // ����ӡ�� ����
}
��ͬ��һ�� ZeroEvenOdd ��ʵ�����ᴫ�ݸ�������ͬ���̣߳�

�߳� A ������ zero()����ֻ��� 0 ��
�߳� B ������ even()����ֻ���ż����
�߳� C ������ odd()����ֻ���������
ÿ���̶߳���һ�� printNumber ���������һ�����������޸ĸ����Ĵ���������������� 010203040506... ���������еĳ��ȱ���Ϊ 2n��

 

ʾ�� 1��

���룺n = 2
�����"0102"
˵���������߳��첽ִ�У�����һ������ zero()����һ���̵߳��� even()�����һ���̵߳���odd()����ȷ�����Ϊ "0102"��
ʾ�� 2��

���룺n = 5
�����"0102030405"
*/
class ZeroEvenOdd {
    private int n;
    int num = 1;
    volatile boolean zero = true, odd = false, even = false;
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(num <=n){
            while(zero != true){Thread.yield();}
            if(num > n) {
                even = true;
                odd = true;
                break;
            }
            synchronized(this){
              printNumber.accept(0);
              zero = false;
              if((num&1)==1) odd = true;
              else even = true;
          }      
        } 
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while(num <=n){
           while(even != true){Thread.yield();}
           if(num > n) break;
           synchronized(this){
               printNumber.accept(num);
               num++;
               even = false;
               zero = true;
           }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while(num <=n){
           while(odd != true){Thread.yield();}
           if(num > n) break;
           synchronized(this){
               printNumber.accept(num);
               num++;
               odd = false;
               zero = true;
           }
        }
    }
}