package code.injectors.track.city.ws.service.multipart;

import javaslang.control.Try;

import java.io.InputStream;

/**
 * @author Chatzakis Nikolaos
 */
public interface MultipartService {

    Try<Void> uploadMultipart(String fullPath, Try.CheckedSupplier<InputStream> multipartInputStream);
}
