# odt-pdf-demo
```shell
curl --location --request POST 'http://127.0.0.1:8080/template/pdf' \
--header 'Content-Type: application/json' \
--data-raw '{
  "fileName": "file.odt",
  "name": "Georgii Ziniakov",
  "dob":"1224abc",
  "iban":"353223425622",
  "bic":"5384289",
  "abi":"131324677",
  "cab":"8923021",
  "cin":"495222113",
  "card":"921945863652",
  "date":"10.12.2020",
  "balance":"150.00",
  "customer": {
      "addressList": [
          {
              "street": "Rungestrasse",
              "streetNumber": "22",
              "city": "Berlin",
              "state": "Approved"
          },
          {
              "street": "Kurfürstenstraße",
              "streetNumber": "72",
              "city": "Berlin",
              "state": "Not approved"
          },
          {
              "street": "Abcstrasse",
              "streetNumber": "72",
              "city": "Berlin",
              "state": "Not approved"
          }
      ]
  }
}' | base64 --decode > tpd.pdf && open tpd.pdf
```