if (weekday < 0 || weekend < 0) {
    throw new BadRequestException("Average daily increase must be >= 0");
}



usagePatternRepository
    .findTopByBinOrderByLastUpdatedDesc(bin);
