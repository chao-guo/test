package chao.design_pattern.abstractfactory;

/**
 * 抽象工厂
 * 提供了产品的生成方法接口
 */
public interface ElectronicFactory {

    public Telephone createTelephone();

    public Television createTelevision();

    public Notebook createNotebook();
}
