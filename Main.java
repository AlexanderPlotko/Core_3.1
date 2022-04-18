package ustanovkaProgrammyi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        File dir = new File("C://Games");
        if (dir.mkdir()) {
            log.append("папка Games создана" + "\n");
        } else {
            log.append("ошибка создания папки Games" + "\n");
        }
        File src = new File(dir, "src");
        File res = new File(dir, "res");
        File save = new File(dir, "savegames");
        File temp = new File(dir, "temp");
        List<File> games = Arrays.asList(src, res, save, temp);
        for (File game : games) {
            if (game.mkdir()) {
                log.append("Папка " + game.getName() + " создана" + "\n");
            } else {
                log.append("ошибка создания папки " + game.getName() + "\n");
            }
        }

        File maine = new File(src, "main");//назвал maine т.к. имя main в проге использовать не рекомендуется
        if (maine.mkdir()) {
            log.append("Папка main создана" + "\n");
        } else {
            log.append("ошибка создания папки main" + "\n");
        }
        if (new File(src, "test").mkdir()) {
            log.append("Папка test создана" + "\n");
        } else {
            log.append("ошибка создания папки test" + "\n");
        }

        File fileMain = new File(maine, "Main.java");
        File fileUtils = new File(maine, "Utils.java");
        List<File> fileJava = Arrays.asList(fileMain, fileUtils); //создали список в него засунули объекты файлов которые надо создать
        for (File java : fileJava) {
            try {
                if (java.createNewFile()) {
                    log.append("Файл " + java.getName() + " создан" + "\n");
                } else {
                    log.append("ошибка создания файла " + java.getName() + "\n");
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        File drawables = new File(res, "drawables");
        File vectors = new File(res, "vectors");
        File icons = new File(res, "icons");
        List<File> resСatalog = Arrays.asList(drawables, vectors, icons);
        for (File catalog : resСatalog) {
            if (catalog.mkdir()) {
                log.append("Папка " + catalog.getName() + " создана" + "\n");
            } else {
                log.append("ошибка создания папки " + catalog.getName() + "\n");
            }
        }

        File file = new File(temp, "temp.txt");
        try {
            if (file.createNewFile()) {
                log.append("файл temp создан" + "\n");
            } else {
                log.append("ошибка создания файла temp");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(log);

        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(String.valueOf(log));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
