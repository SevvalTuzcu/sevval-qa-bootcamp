const chakram = require('chakram');
const expect = chakram.expect;

describe("PetStore CRUD Tests for Pets", function() {

    it("TC_01 POST || Create a new pet", function() {

        const data = {
            "id": 890890,
            "category": {
                "id": 0,
                "name": "string"
            },
            "name": "karabas",
            "photoUrls": [
                "string"
            ],
            "tags": [
                {
                    "id": 0,
                    "name": "string"
                }
            ],
            "status": "available"
        };

        const resData = {
            "id": 890890,
            "category": {
                "id": 0,
                "name": "string"
            },
            "name": "karabas",
            "photoUrls": [
                "string"
            ],
            "tags": [
                {
                    "id": 0,
                    "name": "string"
                }
            ],
            "status": "available"
        };

        return chakram.post("https://petstore.swagger.io/v2/pet", data)
            .then(function (res) {
                expect(res).to.have.status(200);
                expect(res).to.have.json(resData);
            });
    });

    it("TC_02 GET || Find pet by ID", function() {

        const response = chakram.get("https://petstore.swagger.io/v2/pet/890890");
        expect(response).to.have.status(200);
        return chakram.wait();
    });

    it("TC_03 PUT || Update a pet", function() {

        const data = {
            "id": 890890,
            "category": {
                "id": 0,
                "name": "string"
            },
            "name": "comar",
            "photoUrls": [
                "string"
            ],
            "tags": [
                {
                    "id": 0,
                    "name": "string"
                }
            ],
            "status": "available"
        };

        const resData = {
            "id": 890890,
            "category": {
                "id": 0,
                "name": "string"
            },
            "name": "comar",
            "photoUrls": [
                "string"
            ],
            "tags": [
                {
                    "id": 0,
                    "name": "string"
                }
            ],
            "status": "available"
        };

        return chakram.put("https://petstore.swagger.io/v2/pet", data)
            .then(function (res) {
                expect(res).to.have.status(200);
                expect(res).to.have.json(resData);
            });
    });

    it("TC_04 DELETE || Delete pet by ID", function() {

        const response = chakram.delete("https://petstore.swagger.io/v2/pet/890890");
        expect(response).to.have.status(200);
        return chakram.wait();
    });
});