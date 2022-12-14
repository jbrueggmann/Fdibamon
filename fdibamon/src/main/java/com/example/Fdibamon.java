package com.example;

public class Fdibamon {
  public String name;
  public int hitpoints;
  public int attackPower;
  
  public Fdibamon(String name, int hitpoints, int attackPower) {
    this.name = name;
    this.hitpoints = hitpoints;
    this.attackPower = attackPower;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getHitpoints() {
    return hitpoints;
  }
  public void setHitpoints(int hitpoints) {
    this.hitpoints = hitpoints;
  }
  public int getAttackPower() {
    return attackPower;
  }
  public void setAttackPower(int attackPower) {
    this.attackPower = attackPower;
  }

  @Override
  public String toString() {
    return this.name;
  }

  public void attack(Fdibamon enemy) {
    int remainingHitpointsOfEnemy = calculateRemainingHitpointsOfEnemy(enemy.hitpoints);
    enemy.setHitpoints(remainingHitpointsOfEnemy);
  }

  public int calculateRemainingHitpointsOfEnemy(int currentHitpointsOfEnemy) {
    int remainingHitpointsOfEnemy = currentHitpointsOfEnemy - this.attackPower;

    if (remainingHitpointsOfEnemy < 0) {
      remainingHitpointsOfEnemy = 0;
    }

    return remainingHitpointsOfEnemy;
  }
}
