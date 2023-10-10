import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Article> articles = new ArrayList<>();
    Util util = new Util();

    public static void main(String[] args) {
        Article a1 = new Article(1, "안녕하세요, 반갑습니다. 자바공부중이에요", "", Util.getCurrent());
        Article a2 = new Article(2, "자바 질문 좀 할게요 ~", "", Util.getCurrent());
        Article a3 = new Article(3, "정처기 꼭 따야하나요?", "", Util.getCurrent());
        articles.add(a1);
        articles.add(a2);
        articles.add(a3);


        Scanner scan = new Scanner(System.in);

        int lastid = 4;


        while (true) {
            System.out.print("명령어 : ");
            String command = scan.nextLine();
            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다");

                break;
            } else if (command.equals("add")) {
                System.out.print("게시물 제목을 입력해주세요 : ");
                String title = scan.nextLine();
                System.out.print("게시물 내용을 입력해주세요 : ");
                String content = scan.nextLine();
                Article article = new Article(lastid, title, content, Util.getCurrent());
                articles.add(article);
                System.out.println("게시물이 등록되었습니다");
                lastid++;


            } else if (command.equals("list")) {
                for (int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);
                    System.out.println("=============================");
                    System.out.printf("번호 : %d\n", article.getId());
                    System.out.printf("제목 : %s\n", article.getTitle());
                    System.out.printf("내용 : %s\n", article.getContent());
                    System.out.println("=============================");
                }


            } else if (command.equals("update")) {
                System.out.print("수정할 게시물의 번호를 입력하세요 : ");
                int targetId = scan.nextInt();
                scan.nextLine();
                Article article = findById(targetId);
                if (article == null) {
                    System.out.println("해당 게시물을 찾을 수 없습니다");
                } else {


                    System.out.print("새로운 제목 : ");
                    String newTitle = scan.nextLine();
                    System.out.print("새로운 내용 : ");
                    String newContent = scan.nextLine();
                    article.setTitle(newTitle);
                    article.setContent(newContent);


                    System.out.println("게시물 수정이 완료되었습니다");
                }
            } else if (command.equals("delete")) {
                System.out.print("삭제할 게시물의 번호를 입력하세요 : ");
                int targetId = scan.nextInt();
                scan.nextLine();
                Article article = findById(targetId);
                if (article == null) {
                    System.out.println("해당 게시물을 찾을 수 없습니다");
                } else {
                    articles.remove(article);
                }
            } else if (command.equals("detail")) {
                System.out.print("상세보기할 게시물의 번호를 입력하세요 : ");
                int targetId = scan.nextInt();
                scan.nextLine();
                Article article = findById(targetId);
                if (article == null) {
                    System.out.println("해당 게시물을 찾을 수 없습니다");
                } else {
                    System.out.printf("번호 :%d \n", article.getId());
                    System.out.printf("제목 :%s \n", article.getTitle());
                    System.out.printf("내용 :%s \n", article.getContent());
                    System.out.printf("등록 날짜 : %s\n", Util.getCurrent());
                }
            } else if (command.equals("search")) {
                System.out.print("검색할 내용을 작성해주세요 : ");
                String keyword = scan.nextLine();
                ArrayList<Article> searchedArticles = new ArrayList<>();
                for (Article article : articles) {
                    if (article.getTitle().contains(keyword)) {
                        searchedArticles.add(article);
                    }
                    printArticles(searchedArticles);
                }


            }


        }

    }


    static Article findById(int id) {
        Article target = null;
        for (Article article : articles) {
            if (id == article.getId()) {
                target = article;
            }
        }
        return target;
    }

    public static void printArticles(ArrayList<Article> articles) {
        for (Article article : articles) {
            System.out.printf("번호 : %d \n", article.getId());
            System.out.printf("제목 : %s \n", article.getTitle());
            System.out.printf("내용 : %s \n", article.getContent());
            System.out.printf("등록 날짜 : %s \n", Util.getCurrent());


        }


    }
}

