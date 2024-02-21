package game;

public class EnemyAI {
    private String mode = "none";
    public void makeDecision(){
        if(Core.enemy.getHP()<50 || (Play.entityCount[1]<Play.entityCount[0])){
            mode = "attack";
        }
    }
}
