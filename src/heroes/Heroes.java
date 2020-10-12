package heroes;

public interface Heroes {
    public void levelUp(Hero hero, HeroType heroType);
    public void attack();
    public void gainXP(int xpGain,Hero hero);
    public void showHeroStats(Hero hero, HeroType heroType);
}
