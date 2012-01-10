package nl.arnovanoort.wgmgh.readers;

import java.io.InputStream;

import nl.arnovanoort.wgmgh.domain.Rekening;

public interface MutatieReader {

	void process(Rekening rekening, InputStream inputStream);



}
