if (fillPercentage < 0 || fillPercentage > 100) {
    throw new BadRequestException("fillPercentage must be between 0 and 100");
}

if (recordedAt.after(new Timestamp(System.currentTimeMillis()))) {
    throw new BadRequestException("recordedAt cannot be in the future");
}

if (!bin.getActive()) {
    throw new BadRequestException("Bin must be active");
}
