package code.injectors.track.city.ws.service.media;

import code.injectors.track.city.ws.domain.entity.media.Media;
import code.injectors.track.city.ws.service.PageableCrudService;
import javaslang.control.Try;

import java.io.InputStream;

/**
 * @author Chrisostomos Bakouras
 */
public interface MediaService extends PageableCrudService<Media> {

    Try<Void> upload(String mediaId, Try.CheckedSupplier<InputStream> multipartInputStream, String type);
}
