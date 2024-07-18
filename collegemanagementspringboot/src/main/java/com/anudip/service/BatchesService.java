package com.anudip.service;

import com.anudip.entity.Batches;


public interface BatchesService {

	Batches addBatches(Batches batches);
	
	Batches getBatchesDetails(int bid);
	
	Batches updateBatches(Batches batches,Integer bid);
	
	void deleteBatchesDetails(int bid);
}
