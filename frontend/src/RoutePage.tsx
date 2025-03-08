import AppNavbar from "./AppNavbar.tsx";
import {useParams} from "react-router";
import {useLocalStorage} from "@uidotdev/usehooks";
import {Token} from "./user.tsx";
import {Button, Card} from "flowbite-react";
import {FaArrowRight, FaTrain} from "react-icons/fa";

export default function RoutePage() {
    const {from, to, mode, departure} = useParams()
    const [accessToken, _] = useLocalStorage('access_token', {} as Token)

    return (<>
        <AppNavbar/>
        <div className="flex flex-col min-h-screen min-w-screen gap-4 items-center justify-center">
            <h1 className="dark:text-white text-center text-3xl">Лучший подходящий маршрут</h1>
            <Card className="min-w-max" horizontal>
                <div className="flex flex-row gap-4 items-center">
                    <div className="flex flex-row gap-2 items-center">
                        <h5 className="dark:text-white font-bold text-2xl">Москва</h5>
                        <FaTrain className="dark:text-white"/>
                    </div>
                    <div>
                        <FaArrowRight className="dark:text-white"/>
                    </div>
                    <div className="flex flex-row gap-2 items-center">
                        <h5 className="dark:text-white font-bold text-2xl">Пермь</h5>
                        <FaTrain className="dark:text-white"/>
                    </div>
                </div>
                <p className="dark:text-white">Отправление: 9 марта 2025 в 18:20</p>
                <p className="dark:text-white">Прибытие: 9 марта 2025 в 18:20</p>
                <Button>Забронировать билет</Button>
            </Card>
        </div>
    </>)
}