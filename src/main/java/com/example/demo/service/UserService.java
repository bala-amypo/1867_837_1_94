if (userRepository.existsByEmail(email)) {
    throw new BadRequestException("Email already registered");
}

if (role == null) {
    throw new BadRequestException("Role is required");
}
