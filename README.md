# jwt-symmetric-encryption-springboot

What is JWT ?

JSON Web Token (JWT) is an open standard (RFC 7519) that defines a compact and self-contained way for securely transmitting information between parties as a JSON object. This information can be verified and trusted because it is digitally signed. JWTs can be signed using a secret (with the HMAC algorithm) or a public/private key pair using RSA or ECDSA.

Application server should have encryption and decryption mechanism key.
Basically JWT there are two types of encryption mechanisms.

1. **Symmetric Encryption**: A single key is used to encrypt and decrypt the JWT in the authentication server and the application server.

2. **Asymmetric Encryption**: A public key and a private key will be used to encrypt and decrypt the JWT by the authentication server and application server

 