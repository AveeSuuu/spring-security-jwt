# A Wild Way to Implement JWT in Spring Security

This is a sample project showing how to implement JWT **without any external libraries** – only using the Spring ecosystem 😎.

Secret keys and other sensitive-looking stuff are intentionally left visible for educational purposes.

## About the Structure

The use of `...Config.java` classes for defining most beans, along with the `...Facade.java` + `...UseCase.java` pattern, is just one possible approach.  
It’s opinionated and helps with separation of concerns, but you’re absolutely free to organize your application differently (e.g. using `@Component` and `@RequiredArgsConstructor`).

If you prefer to define everything in service classes or stick to simpler layering – go for it!  
This project is meant to showcase *a* way to implement security, not *the* way 😉

## TODO / Might Happen Next 😄

- 🔄 Add support for refresh tokens
- 🧩 Maybe break things into Maven modules – just for the fun of it
