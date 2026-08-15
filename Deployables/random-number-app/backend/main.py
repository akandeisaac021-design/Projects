import random

from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware

app = FastAPI(title="Random Number API")

# Allow the React dev server (Vite default port) to call this API.
app.add_middleware(

    CORSMiddleware,
    allow_origins=[
        "http://localhost:5173",
        "http://127.0.0.1:5173",
    ],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)


@app.get("/")
def root():
    return {"message": "Random Number API is running. Try GET /api/random"}


@app.get("/api/{minimum}/{maximum}")
def get_random_number(minimum: int, maximum: int):
    number = random.randint(minimum, maximum)
    return {"number": number}
