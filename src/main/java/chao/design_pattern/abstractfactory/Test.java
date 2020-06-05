package chao.design_pattern.abstractfactory;

public class Test {
    public static void main(String[] args) {
        ElectronicFactory electronic = new XiaomiFactory();
        Notebook notebook = electronic.createNotebook();
        notebook.type("Hello,world!");
        Telephone telephone = electronic.createTelephone();
        telephone.call(12345678910L);
        Television television = electronic.createTelevision();
        television.play("天天向上");
    }
}
