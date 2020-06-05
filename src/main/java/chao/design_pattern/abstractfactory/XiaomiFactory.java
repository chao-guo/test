package chao.design_pattern.abstractfactory;

public class XiaomiFactory implements ElectronicFactory {
    @Override
    public Telephone createTelephone() {
        return new Mi2S();
    }

    @Override
    public Television createTelevision() {
        return new XiaomiTV5();
    }

    @Override
    public Notebook createNotebook() {
        return new XiaomiNotebook15();
    }
}
