Bin bin = binRepository.findById(binId)
    .orElseThrow(() ->
        new ResourceNotFoundException("Bin not found with id " + binId)
    );
