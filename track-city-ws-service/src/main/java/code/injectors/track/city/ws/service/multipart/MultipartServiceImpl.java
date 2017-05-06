package code.injectors.track.city.ws.service.multipart;

import javaslang.control.Try;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Chatzakis Nikolaos
 */
@Service
public class MultipartServiceImpl implements MultipartService {

    @Override
    public Try<Void> uploadMultipart(String fullPath, Try.CheckedSupplier<InputStream> multipartInputStream) {

        return Try.run(() -> {
            final InputStream inputStream = multipartInputStream.get();

            final OutputStream outStream = new FileOutputStream(fullPath);

            final byte[] buffer = new byte[8 * 1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outStream.close();
        });
    }
}
