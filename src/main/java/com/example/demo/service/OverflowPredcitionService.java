if (daysUntilFull < 0) {
    throw new BadRequestException("daysUntilFull must be >= 0");
}

if (predictedFullDate.before(LocalDate.now())) {
    throw new BadRequestException("predictedFullDate must be today or later");
}



OverflowPrediction prediction = new OverflowPrediction(
    bin,
    predictedDate,
    daysUntilFull,
    latestUsagePattern,
    new Timestamp(System.currentTimeMillis())
);
