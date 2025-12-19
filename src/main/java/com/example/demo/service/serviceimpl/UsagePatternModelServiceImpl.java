if (weekday < 0 || weekend < 0) {
    throw new BadRequestException(
        "Average daily increase values must be greater than or equal to 0"
    );
}
