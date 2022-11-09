class Solution {
    public void dfs(int x,int y,int dir,Robot robot,Set<String> visited){
        robot.clean();
        for(int d=0; d<4 ;d++){
            int new_dir = (dir+d)%4;
            if(new_dir==0 && !visited.contains((x-1)+" "+y) && robot.move()){
                visited.add((x-1)+" "+y);
                dfs(x-1,y,new_dir,robot,vis);
            }
            if(new_dir==1 && !visited.contains(x+" "+(y+1)) && robot.move()){
                visited.add(x+" "+(y+1));
                dfs(x,y+1,new_dir,robot,vis);
            }
            if(new_dir==2 && !visited.contains((x+1)+" "+y) && robot.move()){
                visited.add((x+1)+" "+y);
                dfs(x+1,y,new_dir,robot,vis);
            }
            if(new_dir==3 && !visited.contains(x+" "+(y-1)) && robot.move()){
                visited.add(x+" "+(y-1));
                dfs(x,y-1,new_dir,robot,vis);
            }
            robot.turnRight();
        }
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
    public void cleanRoom(Robot robot) {
        dfs(0,0,0,robot,new HashSet<>());
    }
}
