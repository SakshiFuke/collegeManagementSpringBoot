package com.anudip.serviceimple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.entity.Batches;
import com.anudip.exception.BatchIdNotFoundException;
import com.anudip.repository.BatchesRepository;
import com.anudip.service.BatchesService;

@Service
public class BatchesServiceImpl implements BatchesService {

	@Autowired
	BatchesRepository batchesRepo;
	
	@Override
	public Batches addBatches(Batches batches) {
		return batchesRepo.save(batches);
	}

	@Override
	public Batches getBatchesDetails(int bid) {
		return batchesRepo.findById(bid).orElseThrow(()->new BatchIdNotFoundException("Course id is not correct"));
	}

	@Override
	public Batches updateBatches(Batches batches, Integer bid) {
		Batches UpdateBatches=batchesRepo.findById(bid).orElseThrow(()->new BatchIdNotFoundException("Course id is not correct"));
		UpdateBatches.setDuration(batches.getDuration());
		UpdateBatches.setEnddate(batches.getEnddate());
		return batchesRepo.save(UpdateBatches);
	}

	@Override
	public void deleteBatchesDetails(int bid) {
		Batches deleteBatches=batchesRepo.findById(bid).orElseThrow(()->new BatchIdNotFoundException("Course id is not correct"));
		batchesRepo.delete(deleteBatches);
	}

}
