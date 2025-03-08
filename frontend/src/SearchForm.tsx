import {Button, Datepicker, Label, Select, TextInput} from "flowbite-react";

export default function SearchForm()
{
    return (<div className="flex flex-col min-h-screen min-w-screen gap-4 items-center justify-center">
        <h1 className="dark:text-white text-center text-3xl">Поиск маршрута</h1>
        <form className="flex flex-col w-full items-center gap-4">
            <div className="w-1/2">
                <div className="mb-2 block">
                    <Label htmlFor="from" value="Город отправления"/>
                </div>
                <TextInput id="from" name="from" type="text"/>
            </div>
            <div className="w-1/2">
                <div className="mb-2 block">
                    <Label htmlFor="to" value="Город прибытия"/>
                </div>
                <TextInput id="to" name="to" type="text"/>
            </div>
            <div className="w-1/2">
                <div className="mb-2 block">
                    <Label htmlFor="departure" value="Дата отправления"/>
                </div>
                <Datepicker id="departure" name="departure" minDate={new Date()}/>
            </div>
            <div className="w-1/2">
                <div className="mb-2 block">
                    <Label htmlFor="mode" value="Вид транспорта"/>
                </div>
                <Select id="mode" name="mode" required>
                    <option>Не важно</option>
                    <option>Самолет</option>
                    <option>Поезд</option>
                    <option>Автобус</option>
                </Select>
            </div>
            <Button className="w-1/2" type="submit">Найти</Button>
        </form>
    </div>)
}