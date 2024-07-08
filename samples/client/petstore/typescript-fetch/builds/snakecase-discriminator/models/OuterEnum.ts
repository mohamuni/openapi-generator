/* tslint:disable */
/* eslint-disable */
/**
 * OpenAPI Petstore
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


/**
 * 
 * @export
 */
export const OuterEnum = {
    Placed: 'placed',
    Approved: 'approved',
    Delivered: 'delivered'
} as const;
export type OuterEnum = typeof OuterEnum[keyof typeof OuterEnum];


export function instanceOfOuterEnum(value: any): boolean {
    for (const key in OuterEnum) {
        if (Object.prototype.hasOwnProperty.call(OuterEnum, key)) {
            if (OuterEnum[key as keyof typeof OuterEnum] === value) {
                return true;
            }
        }
    }
    return false;
}

export function OuterEnumFromJSON(json: any): OuterEnum {
    return OuterEnumFromJSONTyped(json, false);
}

export function OuterEnumFromJSONTyped(json: any, ignoreDiscriminator: boolean): OuterEnum {
    return json as OuterEnum;
}

export function OuterEnumToJSON(value?: OuterEnum | null): any {
    return value as any;
}

