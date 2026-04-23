class MyTask implements Runnable {
    private String taskName;

    public MyTask(String name) {
        this.taskName = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(taskName + " орындалуда: " + i);
            try {
                Thread.sleep(1000); // 1 секунд күту
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(taskName + " аяқталды.");
    }
}

public class Main {
    public static void main(String[] args) {
        // Екі бөлек ағын құру
        Thread thread1 = new Thread(new MyTask("Файл жүктеу"));
        Thread thread2 = new Thread(new MyTask("Есептеу жұмысы"));

        // Ағындарды іске қосу
        thread1.start();
        thread2.start();
    }
}
