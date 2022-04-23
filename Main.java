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
        createDirectory(games, log);

        File maine = new File(src, "main");//назвал maine т.к. имя main в проге использовать не рекомендуется
        File test = new File(src, "test");
        List<File> srcCatalog = Arrays.asList(maine, test);
        createDirectory(srcCatalog, log);

        File fileMain = new File(maine, "Main.java");
        File fileUtils = new File(maine, "Utils.java");
        createFile(fileMain, log);
        createFile(fileUtils, log);

        File drawables = new File(res, "drawables");
        File vectors = new File(res, "vectors");
        File icons = new File(res, "icons");
        List<File> resСatalog = Arrays.asList(drawables, vectors, icons);
        createDirectory(resСatalog, log);

        File file = new File(temp, "temp.txt");
        createFile(file, log);

        System.out.println(log);

        try (FileWriter writer = new FileWriter(file, false)) {//запись логов в файл temp
            writer.write(String.valueOf(log));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private static void createDirectory(List<File> catalog, StringBuilder log) {
        for (File cat : catalog) {
            if (cat.mkdir()) {
                log.append("Папка " + cat.getName() + " создана" + "\n");
            } else {
                log.append("ошибка создания папки " + cat.getName() + "\n");
            }
        }
    }

    private static void createFile (File file, StringBuilder log) {
        try {
            if (file.createNewFile()) {
                log.append("файл " + file.getName() + " создан" + "\n");
            } else {
                log.append("ошибка создания файла " + file.getName() + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
