from fastapi import FastAPI
from router.run import router as run_router
import uvicorn


app = FastAPI()

app.include_router(run_router)


def main():
    uvicorn.run(app, host="127.0.0.1", port=8000, log_level="debug", reload=True)

if __name__ == "__main__":
    main()