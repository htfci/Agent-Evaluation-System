import uvicorn
from fastapi import FastAPI
import uvicorn


app = FastAPI()

# app.include_router()

def main():
    uvicorn.run(app, host="127.0.0.1", port=8000, log_level="debug", reload=True)

if __name__ == "__main__":
    main()