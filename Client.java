import com.rabbitmq.client.*;

import java.io.BufferedInputStream; import java.io.File; import java.io.FileInputStream; import java.io.IOException; import java.io.InputStream; import java.io.PrintWriter; import java.util.ArrayList;

public class Client {

private static final String TASK_QUEUE_NAME = "task_queue";

private static ArrayList<String> listFilesForFolder(final File folder) {
	System.out.println(folder);
    ArrayList<String> filesName = new ArrayList<String>();
    for (final File fileEntry : folder.listFiles()) {
        if (fileEntry.isDirectory()) {
            listFilesForFolder(fileEntry);
        } else {
             System.out.println(fileEntry.getName());
            filesName.add(fileEntry.getName());
        }
    }
    return filesName;
}

public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

    String path = "input"; // Location of the
                                                        // folder related to
                                                        // home
    final File folder = new File(path);
    ArrayList<String> filesName = new ArrayList<String>();
    filesName = listFilesForFolder(folder);
    int numberOfFiles =1;
    System.out.println("Total Number of files: " + filesName.size());
    for (String fileName : filesName) {
        System.out.println(numberOfFiles + " " + fileName);
        String FileNameWithPath = path + "/" + fileName;
        numberOfFiles++;
        channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN,
                FileNameWithPath.getBytes("UTF-8"));
        System.out.println(" [x] Sent '" + FileNameWithPath + "'");
    }
    channel.close();
    connection.close();
}
}


