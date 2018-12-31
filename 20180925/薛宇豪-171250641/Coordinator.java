public class Coordinator {
    public char[][] command(Role[] roles,Formation formation){
        char[][] space=formation.embattle(roles);
        return space;
    }
}
