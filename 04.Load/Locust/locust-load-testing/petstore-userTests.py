from locust import HttpUser, between, task


class WebsiteUser(HttpUser):
    wait_time = between(5, 15)

    @task
    def post_user_create(self):
        payload = {
            "id": 123456,
            "username": "tolunay12345",
            "firstName": "john",
            "lastName": "doe",
            "email": "johndoe@mail.com",
            "password": "1234",
            "phone": "90123456789",
            "userStatus": 1
            }
        self.client.post("/v2/user", json=payload)

    @task
    def get_user_info(self):
        self.client.get("/v2/user/tolunay12345")

    @task
    def get_user_login(self):
        payload = {
            "username": "tolunay12345",
            "password": "1234"
        }
        self.client.get("/v2/user/login", params=payload)

    @task
    def put_user_update(self):
        payload = {
            "id": 123456,
            "username": "tolunay12345",
            "firstName": "john",
            "lastName": "doe",
            "email": "johndoe@mail.com",
            "password": "1234",
            "phone": "42123456789",
            "userStatus": 1
        }
        self.client.put("/v2/user/tolunay12345", json=payload)

    @task
    def get_user_logout(self):
        self.client.get("/v2/user/logout")

    # @task
    # def delete_user(self):
    #     payload = {
    #         "id": 123456,
    #         "username": "tolunay1234del",
    #         "firstName": "john",
    #         "lastName": "doe",
    #         "email": "johndoe@mail.com",
    #         "password": "1234",
    #         "phone": "90123456789",
    #         "userStatus": 1
    #     }
    #     self.client.post("/v2/user", json=payload)
    #     self.client.delete("/v2/user/tolunay1234del")

    @task
    def create_user_with_array(self):
        payload = [
            {
                "id": 12341234,
                "username": "tolunay123array",
                "firstName": "jane",
                "lastName": "doe",
                "email": "janedoe@mail.com",
                "password": "1234",
                "phone": "90987654321",
                "userStatus": 2
            }]
        self.client.post("/v2/user/createWithArray", json=payload)
        #self.client.delete("/v2/user/tolunay1234del")