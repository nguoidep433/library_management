package App;

import LibManagement.Model.LibManagement;

public class App {
    public static void main(String[] args) throws Exception{
            LibManagement.createDB();
            LibManagement lib = new LibManagement();
    }
}