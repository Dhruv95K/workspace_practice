package SingletonFactory;

public class HeroSingletonFactory {
    private static volatile HeroSingletonFactory heroSingletonFactoryInstance = null;

    private HeroSingletonFactory() {
    }

    public HeroSingletonFactory getInstance() {
        if(heroSingletonFactoryInstance == null) {
            synchronized (this){
                if(heroSingletonFactoryInstance == null) {
                    heroSingletonFactoryInstance = new HeroSingletonFactory();
                }
            }
        }
        return heroSingletonFactoryInstance;
    }

    public Hero createHero(String name) {
        if(name.equalsIgnoreCase("Batman"))
            return new Batman();
        else if(name.equalsIgnoreCase("Superman"))
            return new Superman();

        return null;
    }
}
