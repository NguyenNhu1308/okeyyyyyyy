# Java-Microservices-CQRS-Event-Sourcing-with-Kafka

![1](https://user-images.githubusercontent.com/54174687/181909157-8e94e67a-b106-415a-ac40-efe514c89e96.png)

You can point to Postgres DB (treat as a read db)

# Open Bank Account

```sh
curl --location --request POST 'http://localhost:5001/api/v1/openBankAccount' \
--header 'Content-Type: application/json' \
--data-raw '{
    "accountHolder": "john Doe",
    "accountType": "SAVINGS",
    "openingBalance": 50.0
}'
```

Response:

```
{
    "message": "Bank account creation request completed successfully!",
    "id": "0266c886-8267-4e9c-96ed-3dfb66aac4c4"
}
```

<img width="897" alt="Screenshot 2022-07-30 at 2 41 30 PM" src="https://user-images.githubusercontent.com/54174687/181903734-e96573db-9583-42ac-9aad-f2df0cea11ec.png">
<img width="1045" alt="Screenshot 2022-07-30 at 2 41 40 PM" src="https://user-images.githubusercontent.com/54174687/181903748-f37bd3f7-c0f8-4710-a8a0-57ad6beb68ee.png">
<img width="832" alt="Screenshot 2022-07-30 at 2 41 52 PM" src="https://user-images.githubusercontent.com/54174687/181903755-2b129749-da4f-4281-a349-623efbf0e36d.png">
<img width="1196" alt="Screenshot 2022-07-30 at 2 44 42 PM" src="https://user-images.githubusercontent.com/54174687/181903850-a830de51-fbfe-45b7-a55b-e6574c552ff0.png">

-----

# Deposit Funds

```sh
curl --location --request PUT 'http://localhost:5001/api/v1/depositFunds/0266c886-8267-4e9c-96ed-3dfb66aac4c4' \
--header 'Content-Type: application/json' \
--data-raw '{
    "amount": 150.0
}'
```

Response:

```json
{
    "message": "Deposit funds request completed successfully!"
}
```
<img width="903" alt="Screenshot 2022-07-30 at 2 47 25 PM" src="https://user-images.githubusercontent.com/54174687/181904044-e152a4b6-f3c3-4631-8f3a-f883cc276769.png">

<img width="1031" alt="Screenshot 2022-07-30 at 2 47 43 PM" src="https://user-images.githubusercontent.com/54174687/181904049-776f72f8-1773-46b8-a4ef-b19f6aafb84a.png">
<img width="829" alt="Screenshot 2022-07-30 at 2 47 54 PM" src="https://user-images.githubusercontent.com/54174687/181904054-73de81fc-e958-44ad-a32d-faa8dd121403.png">
<img width="1189" alt="Screenshot 2022-07-30 at 2 49 04 PM" src="https://user-images.githubusercontent.com/54174687/181904055-554f2756-14e8-4ea7-9bdd-3078e13cf400.png">

--------

# Withdraw Funds

```sh
curl --location --request PUT 'http://localhost:5001/api/v1/withdrawFunds/0266c886-8267-4e9c-96ed-3dfb66aac4c4' \
--header 'Content-Type: application/json' \
--data-raw '{
    "amount": 15.0
}'
```

Response:
<img width="898" alt="Screenshot 2022-07-30 at 2 55 24 PM" src="https://user-images.githubusercontent.com/54174687/181904541-5f914aee-bcdf-4929-b98f-de3090ebdf64.png">
<img width="1045" alt="Screenshot 2022-07-30 at 2 55 50 PM" src="https://user-images.githubusercontent.com/54174687/181904544-af02a5aa-7a7c-45ea-b66c-08669f9b274a.png">
<img width="1032" alt="Screenshot 2022-07-30 at 2 56 21 PM" src="https://user-images.githubusercontent.com/54174687/181904548-e1917d08-3e02-4f1b-a222-5c3ba6340540.png">
<img width="685" alt="Screenshot 2022-07-30 at 3 04 24 PM" src="https://user-images.githubusercontent.com/54174687/181904551-9cb93ef7-f4af-4a83-9b77-575d91f34478.png">

--------

# Close Account

DELETE `http://localhost:5001/api/v1/closeBankAccount/0266c886-8267-4e9c-96ed-3dfb66aac4c4`

<img width="1066" alt="Screenshot 2022-07-30 at 3 08 22 PM" src="https://user-images.githubusercontent.com/54174687/181904707-851f90ed-bf31-46de-a036-2f8770120491.png">
<img width="410" alt="Screenshot 2022-07-30 at 3 08 35 PM" src="https://user-images.githubusercontent.com/54174687/181904712-3a9ea97a-a6e1-4248-9ef0-93b4ee7dc527.png">
<img width="1189" alt="Screenshot 2022-07-30 at 3 09 12 PM" src="https://user-images.githubusercontent.com/54174687/181904713-9b4d1c2a-b912-46ee-98e7-4b0909f72a3e.png">

--------

# Account Lookup

GET -> `http://localhost:5002/api/v1/bankAccountLookup/`

Response:

```json
{
    "message": "Successfully returned 2 bank account(s)!",
    "accounts": [
        {
            "id": "9e9e8bf3-65a7-4d6c-9ac1-de79c52017a7",
            "accountHolder": "Jane Doe",
            "creationDate": "2022-07-30T09:44:06.971+00:00",
            "accountType": "CURRENT",
            "balance": 200.0
        },
        {
            "id": "fc949c5e-a3ec-4b2a-ad75-eeed3a150998",
            "accountHolder": "Mike Doe",
            "creationDate": "2022-07-30T09:44:15.761+00:00",
            "accountType": "SAVINGS",
            "balance": 300.0
        }
    ]
}
```

-------

# Find By Account Id

GET -> `http://localhost:5002/api/v1/bankAccountLookup/byId/9e9e8bf3-65a7-4d6c-9ac1-de79c52017a7`

Response:

```json
{
    "message": "Successfully returned bank account!",
    "accounts": [
        {
            "id": "9e9e8bf3-65a7-4d6c-9ac1-de79c52017a7",
            "accountHolder": "Jane Doe",
            "creationDate": "2022-07-30T09:44:06.971+00:00",
            "accountType": "CURRENT",
            "balance": 200.0
        }
    ]
}
```
------

# Find By Account Holder Id

GET -> `http://localhost:5002/api/v1/bankAccountLookup/byHolder/Jane Doe`

GET -> `http://localhost:5002/api/v1/bankAccountLookup/withBalance/GREATER_THAN/50`

-----

# Restore Read DB

GET -> `http://localhost:5001/api/v1/restoreReadDb`

# ok
"# okeyyyyyyy" 
