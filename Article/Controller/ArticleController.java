package Article.Controller;

import Model.Article;
import Model.ArticleRepository;
import View.ArticleView;
import util.Util;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArticleController {

    ArticleView articleView = new ArticleView();
    ArticleRepository articleRepository = new ArticleRepository();


    Scanner scan = new Scanner(System.in);


    public void exit() {
        System.out.print("명령어 : ");
        String command = scan.nextLine();
        if (command.equals("exit")) {
            System.out.println("프로그램을 종료합니다");

        }
    }

    public void add() {
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = scan.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String content = scan.nextLine();
        articleRepository.insert(title, content);
        System.out.println("게시물이 등록되었습니다");


    }


    public void list() {
        ArrayList<Article> articles = articleRepository.findAllArticles();
        articleView.printArticles(articles);
    }

    public void update() {
        System.out.print("수정할 게시물의 번호를 입력하세요 : ");
        int targetId = getParamInt(scan.nextLine(),-1);
        if(targetId==-1){
            return;
        }
        Article article = articleRepository.findById(targetId);
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
    }


    public void delete() {
        System.out.print("삭제할 게시물의 번호를 입력하세요 : ");
        int targetId = getParamInt(scan.nextLine(),-1);
        if(targetId==-1){
            return;
        }
        Article article = articleRepository.findById(targetId);
        if (article == null) {
            System.out.println("해당 게시물을 찾을 수 없습니다");
        } else {
            articleRepository.eliminate(article);
        }
    }

    public void detail() {
        System.out.print("상세보기할 게시물의 번호를 입력하세요 : ");
        int targetId = getParamInt(scan.nextLine(),-1);
        if(targetId==-1){
            return;
        }

        Article article = articleRepository.findById(targetId);
        if (article == null) {
            System.out.println("해당 게시물을 찾을 수 없습니다");
        } else {
            article.setHit(article.getHit() + 1);

            articleView.printArticle(article);


        }
    }

    public void search() {
        System.out.print("검색할 내용을 작성해주세요 : ");
        String keyword = scan.nextLine();
        ArrayList<Article> searchedArticles = articleRepository.findByTitle(keyword);
        articleView.printArticles(searchedArticles);
    }

    public int getParamInt(String input, int defaultVaule) {
        try {
            int num = Integer.parseInt(input);
            return num;
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요");
        }

        return defaultVaule - 1;
    }


}










