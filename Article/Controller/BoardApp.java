package Article.Controller;

import java.util.Scanner;

public class BoardApp {
    static ArticleController articleController = new ArticleController();

    public static void start() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("명령어 : ");
            String command = scan.nextLine();
            if (command.equals("exit")) {
                articleController.exit();
                break;
            } else if (command.equals("add")) {
                articleController.add();
            } else if (command.equals("list")){
                articleController.list();
            }else if (command.equals("update")){
                articleController.update();
            }else if (command.equals("delete")){
                articleController.delete();
            }else if (command.equals("detail")){
                articleController.detail();
            }else if (command.equals("search")){
                articleController.search();
            }
        }

    }
}
