# Homework3
## This homework includes 3 modules: Creature.java, Formation.java and Ground.java
1. Creature.java: defines class Creature, HuluBro, Grandpa, Snake, Scorpion and Slime.
The last 5 classes extends from class Creature, because they are all creatures and they hava some common features,like position coordinates and movement from one place to another.
In this module, I used inheritance.

2. Formation.java: defines an interface includes 8 different formations used by grandpa and scorpion.So, class Grandpa and Scorpion have to implement Formation.
In this module, I used inteface.

3. Ground.java: defines a N\*N-sized map, records each plaec's information.Notes: number 1-7 stand for HuluBrothers from RED to PURPLE,
8 for grandpa, & for scorpion, @ for snake and  * for Slime.

## Concept
1. HuluBrothers and Slimes are considered to be able to move from one place to another place, but not able to form a formation. 
So grandpa and scorpion are given this ability. They can tell HuluBrothers and Slimes how to form a formation. Therefore, Grandpa and Scorpion implements from Formation.
2. Ground is considered to be able to record information about which place is occupied and who occupies it. 

## Shortcoming
Since Grandpa only uses one formation, there are some functions in Formation that will not be used by Grandpa. Therefore, there are some blank functions in class Grandpa.